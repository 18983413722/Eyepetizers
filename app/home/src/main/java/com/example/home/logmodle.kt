package com.example.home
import com.google.gson.annotations.SerializedName

// API 响应根结构

data class ApiResponse(
    @SerializedName("itemList") val itemList: List<FeedItem>,
    @SerializedName("adTrack") val adTrack: Any? = null
)

// Feed 流项目基类

sealed class FeedItem {
    abstract val type: String
    abstract val data: BaseData
    abstract val id: Int
    abstract val adIndex: Int
}

// 文本标题卡片

data class TextCardItem(
    @SerializedName("type") override val type: String,
    @SerializedName("data") override val data: TextCardData,
    @SerializedName("id") override val id: Int,
    @SerializedName("adIndex") override val adIndex: Int
) : FeedItem()


// 视频卡片

data class FollowCardItem(
    @SerializedName("type") override val type: String,
    @SerializedName("data") override val data: FollowCardData,
    @SerializedName("id") override val id: Int,
    @SerializedName("adIndex") override val adIndex: Int
) : FeedItem()

// 数据基类

sealed class BaseData

//文本卡片数据

data class TextCardData(
    @SerializedName("dataType") val dataType: String,
    @SerializedName("text") val text: String,
    @SerializedName("type") val type: String?,
    @SerializedName("subTitle") val subTitle: String? = null
) : BaseData()

//视频卡片数据

data class FollowCardData(
    @SerializedName("dataType") val dataType: String,
    @SerializedName("header") val header: CardHeader,
    @SerializedName("content") val content: CardContent,
    @SerializedName("adTrack") val adTrack: List<Any>? = null
) : BaseData()

// 卡片头部信息（作者/频道）

data class CardHeader(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("icon") val icon: String,//频道图标
    @SerializedName("description") val description: String,//描述
    @SerializedName("time") val time: Long, //视频发布时间
    @SerializedName("showHateVideo") val showHateVideo: Boolean,
    @SerializedName("actionUrl") val actionUrl: String? = null//跳转url
)

//卡片内容

data class CardContent(
    @SerializedName("type") val type: String,
    @SerializedName("data") val data: VideoData
)

// 视频数据

data class VideoData(
    @SerializedName("dataType") val dataType: String,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,//视频标题
    @SerializedName("description") val description: String,//视频描述
    @SerializedName("library") val library: String,//视频库（如"DAILY"表示每日编辑精选）
    @SerializedName("tags") val tags: List<Tag>,
    @SerializedName("resourceType") val resourceType: String,
    @SerializedName("provider") val provider: Provider,//视频来源（如YouTube）
    @SerializedName("category") val category: String,
    @SerializedName("author") val author: Author,//作者信息（与header中的信息类似，但结构不同）
    @SerializedName("cover") val cover: Cover,//封面图（不同尺寸）
    @SerializedName("playUrl") val playUrl: String,//视频播放地址
    @SerializedName("duration") val duration: Int,// 视频时长（秒）
    @SerializedName("webUrl") val webUrl: WebUrl,//网页链接（包含raw原始链接和forWeibo微博链接）
    @SerializedName("releaseTime") val releaseTime: Long,//发布时间戳
    @SerializedName("playInfo") val playInfo: List<PlayInfo>?,//播放信息列表（不同清晰度的播放地址）
    @SerializedName("consumption") val consumption: Consumption
)

 //视频标签

data class Tag(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("actionUrl") val actionUrl: String,
    @SerializedName("bgPicture") val bgPicture: String,
    @SerializedName("headerImage") val headerImage: String
)


// 视频来源

data class Provider(
    @SerializedName("name") val name: String,// 来源名称（如"YouTube"）
    @SerializedName("alias") val alias: String,//别名
    @SerializedName("icon") val icon: String//来源图标URL
)

//作者信息
data class Author(
    @SerializedName("id") val id: Int,
    @SerializedName("icon") val icon: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("link") val link: String,
    @SerializedName("latestReleaseTime") val latestReleaseTime: Long,
    @SerializedName("videoNum") val videoNum: Int,
    @SerializedName("ifPgc") val ifPgc: Boolean
)



data class Cover(
    @SerializedName("feed") val feed: String,
    @SerializedName("detail") val detail: String,
    @SerializedName("blurred") val blurred: String,
    @SerializedName("homepage") val homepage: String?
)


// 网页链接

data class WebUrl(
    @SerializedName("raw") val raw: String,//原始网页链接
    @SerializedName("forWeibo") val forWeibo: String//用于微博分享的链接
)


// 播放信息

data class PlayInfo(
    @SerializedName("height") val height: Int,//视频高度
    @SerializedName("width") val width: Int,//视频宽度
    @SerializedName("name") val name: String,//清晰度名称（如“高清”）
    @SerializedName("type") val type: String,//清晰度类型（如"high"
    @SerializedName("url") val url: String//播放地址
)


//用户消费数据

data class Consumption(
    @SerializedName("collectionCount") val collectionCount: Int,
    @SerializedName("shareCount") val shareCount: Int,
    @SerializedName("replyCount") val replyCount: Int
)
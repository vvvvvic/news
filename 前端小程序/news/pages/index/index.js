//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    titleBar: [],
    defaultNewsTypeId: 1001,  // 设置首页的默认新闻分类
    defaultTypeIndex: 0,     // 定义默认的分类下标
    newsList: []
  },

  showDetail(e) {
    var newsId = e.currentTarget.dataset.newsid;
    wx.navigateTo({
      url: '/pages/details/details?newsId=' + newsId,
    })
    console.log(newsId)
  },

  switchNews(e) {
    this.setData({
      defaultNewsTypeId: e.currentTarget.dataset.typeid,
      defaultTypeIndex: e.currentTarget.dataset.index
    })
    this.fetchNewsList();
  },

  onLoad() {
    var that = this;
    wx.request({
      url: `${app.serverUrl}/type/all`,
      header: {
        'content-type': 'application/json' // 默认值
      },
      success(res) {
        if (res.data.status === 200) {
          that.setData({
            titleBar: res.data.data
          });
        }
      }
    })

    // 获取默认的新闻列表
    that.fetchNewsList();
  },

  fetchNewsList() {
    var that = this;
    wx.request({
      url: `${app.serverUrl}/news/list?typeId=${that.data.defaultNewsTypeId}`,
      header: {
        'content-type': 'application/json' // 默认值
      },
      success(res) {
        if (res.data.status === 200) {
          res.data.data.map((item) => {
            if (item.coverImg) {
              item.coverImg = JSON.parse(item.coverImg)
            }else {
              item.coverImg = []
            }
          })
          that.setData({
            newsList: res.data.data
          });
        }
        console.log('newsList', that.data.newsList)
      }
    })
  }
  
})

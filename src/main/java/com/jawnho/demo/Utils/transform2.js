var mpDatas = "mpDatas";
var wxData = "wxData";
// 查询公司表中的数据
var mpCursor = db.getCollection(mpDatas).find(
    {dateStr: {$gte: '2019-07-10'}});

while (mpCursor.hasNext()) {

  //遍历属性 封装到wxData中
  var mp = mpCursor.next();
  var wx = {
    "appId": mp.appId,
    "ref_date": mp.ref_date,
    "visit_uv": mp.active_user_amount,
    "visit_uv_new": mp.registered_user_amount,
    "share_uv": mp.share_user_amount,
    "share_pv": mp.share_time_amount,
    "visit_uv_new_by_session": mp.new_user_amount_by_session,
    "visit_uv_new_by_search": mp.new_user_amount_by_search,
    "visit_uv_new_by_other_mp": mp.new_user_amount_by_other_mp,
    "banner_ad_income": mp.banner_income,
    "video_ad_income": mp.video_income,
    "morrow_retain_ratio": mp.active_user_morrow_retain_ratio,
    "three_day_retain_ratio": mp.active_user_three_day_retain_ratio,
    "seven_day_retain_ratio": mp.active_user_seven_day_retain_ratio,
    "jump_count": 0,
    "createTimestamp": mp.createAt,
    "updateTimestamp": mp.createAt
  }

  // 更新留存相关的字段
  db.getCollection(wxData).insert(wx);
}
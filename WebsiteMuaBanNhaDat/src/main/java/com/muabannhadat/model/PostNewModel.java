package com.muabannhadat.model;

import java.util.List;

import com.muabannhadat.entity.NewsTypeEntity;
import com.muabannhadat.entity.PackageTypeEntity;

public class PostNewModel {
private String title;
private String name_packagetype;
private String name_newstype;
private PackageTypeEntity type_id;
private NewsTypeEntity news_id;
private String start_day;
private String end_day;
private PostDetailModel detail;
private List<CommentModel> comments;
private List<FeedbackModel> feedbacks;
private int ngay;
private UserModel user;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getName_packagetype() {
	return name_packagetype;
}
public void setName_packagetype(String name_packagetype) {
	this.name_packagetype = name_packagetype;
}
public String getName_newstype() {
	return name_newstype;
}

public PackageTypeEntity getType_id() {
	return type_id;
}
public void setType_id(PackageTypeEntity type_id) {
	this.type_id = type_id;
}
public NewsTypeEntity getNews_id() {
	return news_id;
}
public void setNews_id(NewsTypeEntity news_id) {
	this.news_id = news_id;
}
public void setName_newstype(String name_newstype) {
	this.name_newstype = name_newstype;
}
public String getStart_day() {
	return start_day;
}
public void setStart_day(String start_day) {
	this.start_day = start_day;
}
public String getEnd_day() {
	return end_day;
}
public void setEnd_day(String end_day) {
	this.end_day = end_day;
}
public PostDetailModel getDetail() {
	return detail;
}
public void setDetail(PostDetailModel detail) {
	this.detail = detail;
}
public List<CommentModel> getComments() {
	return comments;
}
public void setComments(List<CommentModel> comments) {
	this.comments = comments;
}
public List<FeedbackModel> getFeedbacks() {
	return feedbacks;
}
public void setFeedbacks(List<FeedbackModel> feedbacks) {
	this.feedbacks = feedbacks;
}
public UserModel getUser() {
	return user;
}
public void setUser(UserModel user) {
	this.user = user;
}
public int getNgay() {
	return ngay;
}
public void setNgay(int ngay) {
	this.ngay = ngay;
}


	
}

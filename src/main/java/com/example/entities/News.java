package com.example.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "News_id")
    private int NewsId;

    @Column(name = "News_url", length = 255, nullable = false)
    private String NewsUrl;

     @Column(name = "News_title", length  = 255, nullable = false)
    private String NewsTitle;

    @Column(name = "News_description", length = 255, nullable = false)
    private String NewsDescrption;

	public int getNewsId() {
		return NewsId;
	}

	public void setNewsId(int newsId) {
		NewsId = newsId;
	}

	public String getNewsUrl() {
		return NewsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		NewsUrl = newsUrl;
	}

	public String getNewsTitle() {
		return NewsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}

	public String getNewsDescrption() {
		return NewsDescrption;
	}

	public void setNewsDescrption(String newsDescrption) {
		NewsDescrption = newsDescrption;
	}

}
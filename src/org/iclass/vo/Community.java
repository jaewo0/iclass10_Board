package org.iclass.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Community {
	private long idx;
	private String writer;
	private String title;
	private String content;
	private int readCount;
	private Timestamp createdAt;
	private String ip;
	private String commentCount;
}

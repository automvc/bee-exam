/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.file;

import java.util.Map;

import org.teasoft.bee.osql.annotation.Entity;
import org.teasoft.bee.osql.annotation.GenId;
import org.teasoft.bee.osql.annotation.GridFs;
import org.teasoft.bee.osql.annotation.GridFsMetadata;

/**
 * @author Kingstar
 * @since  2.1
 */
@Entity("HistoryFile")
public class HistoryFile4 {
	
	@GenId
	private Long id;
	
	private String name;
	
	private String filename;
	
	//查询时,可以唯一指定      但不一定知道;   插入时,由框架保存了文件后,帮填入
	private String fileid;
	
	@GridFs
	private byte[] file;
	
	@GridFsMetadata
	private Map<String,Object> metadata;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}
	
}

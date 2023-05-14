package org.teasoft.exam.bee.mongodb.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Honey
 * Create on 2023-04-26 17:19:44
 */
public class Movies implements Serializable {

	private static final long serialVersionUID = 1595621942874L;

	private String id;
	private String title;
	private List genres;
	private Double runtime;
	private String rated;
	private Double year;
	private List directors;
	private List cast;
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List getGenres() {
		return genres;
	}

	public void setGenres(List genres) {
		this.genres = genres;
	}

	public Double getRuntime() {
		return runtime;
	}

	public void setRuntime(Double runtime) {
		this.runtime = runtime;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public Double getYear() {
		return year;
	}

	public void setYear(Double year) {
		this.year = year;
	}

	public List getDirectors() {
		return directors;
	}

	public void setDirectors(List directors) {
		this.directors = directors;
	}

	public List getCast() {
		return cast;
	}

	public void setCast(List cast) {
		this.cast = cast;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
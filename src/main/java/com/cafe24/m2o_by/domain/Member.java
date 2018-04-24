package com.cafe24.m2o_by.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {

	@Id
	@Column(name = "MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
  
	private String name;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", team=" + team + "]";
	}

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

	public Team getTeam() {
		return team;
	}

	void setTeam(Team team) {
		this.team = team;

		// 무한 루프 빠지지 않도록 체크
		if (team.getMembers().contains(this) == false) {
			team.getMembers().add(this);
		}
	}

}

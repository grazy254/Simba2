package com.simba.controller.vo;

import com.simba.model.Blacklist;
import com.simba.model.Fans;

public class BlackListVo {

	private Blacklist blacklist;

	private Fans fans;

	public Blacklist getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(Blacklist blacklist) {
		this.blacklist = blacklist;
	}

	public Fans getFans() {
		return fans;
	}

	public void setFans(Fans fans) {
		this.fans = fans;
	}

}

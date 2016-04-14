package com.zeptoh.lynk.common;

import com.zeptoh.lynk.model.SelectedContent;

public interface CommonDao {
	public void storeLynk(Object obj);
	public SelectedContent retrieveLynk(String token);
}

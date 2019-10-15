package com.Inventory.MWJ.Service;

import java.io.IOException;

import com.Inventory.MWJ.Model.BseData;

public interface BseDataService {
	public BseData setData(BseData bsedata);

	public void setData() throws IOException;
}

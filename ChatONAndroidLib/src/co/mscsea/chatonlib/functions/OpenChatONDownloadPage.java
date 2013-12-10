/*
 * Copyright 2013 Samsung Developer Relations Team (MSCSEA)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package co.mscsea.chatonlib.functions;

import android.content.Context;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.sec.chaton.clientapi.UtilityAPI;

public class OpenChatONDownloadPage implements FREFunction {

	/**
	 * Open page to download ChatON
	 * 
	 * @param frecontext
	 * @param args
	 * @return null
	 */
	@Override
	public FREObject call(FREContext frecontext, FREObject[] args) {
		try {
			Context context = frecontext.getActivity();
			
			UtilityAPI.openChatONDownloadPage(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

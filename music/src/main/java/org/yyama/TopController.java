package org.yyama;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.yyama.Common.Common;
import org.yyama.Form.SelectList;
import org.yyama.Service.MusicSelectService;

@Controller
public class TopController {
	
	// キーワード検索を行うクラス
	@Autowired
	MusicSelectService musicSelectService;

	// 初期表示時
	@RequestMapping(value="/")
	public ModelAndView index(ModelAndView mav) {

		// 次画面設定
		mav.setViewName("top");
		return mav;
	}
	
	// Enterボタン押下時
	@RequestMapping(value="/top",params="enter", method=RequestMethod.GET)
	public ModelAndView reload(ModelAndView mav) {

		// 選択キーワード数用リストを設定
		mav.addObject("selectLimitMap", Common.getSelectedLimit());
		
		// キーワード検索を行い、結果を保持
		List<Map<String,Object>> list = musicSelectService.findMusicList();
		mav.addObject("lists", list);
		
		// 入力フォームの生成
		mav.addObject("selectList", new SelectList());
		mav.setViewName("index");
		return mav;
	}
	
}

package org.yyama;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.yyama.Common.Common;
import org.yyama.Form.SelectList;
import org.yyama.Service.MusicSelectService;

@Controller
public class IndexController {

	@Autowired
	HttpSession session;

	// キーワード検索を行うクラス
	@Autowired
	MusicSelectService musicSelectService;

	// REROADボタン押下時
	@RequestMapping(value = "/index", params = "reload", method = RequestMethod.GET)
	public ModelAndView reload(ModelAndView mav) {

		// セッションクリア
		session.invalidate();

		List<Map<String, Object>> list = musicSelectService.findMusicList();

		mav.addObject("selectLimitMap", Common.getSelectedLimit());
		mav.addObject("lists", list);
		mav.addObject("selectList", new SelectList());
		mav.setViewName("index");
		return mav;
	}

	// SEARCHボタン押下時
	@RequestMapping(value = "/index", params = "search", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute SelectList selectList, ModelAndView mav) {

		List<Map<String, Object>> list = musicSelectService.test(selectList.getSelectedItem());

		mav.addObject("selectLimitMap", Common.getSelectedLimit());
		mav.addObject("lists", list);
		// セッションに設定
		session.setAttribute("selectList", selectList);
		mav.setViewName("index");
		return mav;
	}

}

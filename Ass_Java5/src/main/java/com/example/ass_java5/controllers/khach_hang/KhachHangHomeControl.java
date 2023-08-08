package com.example.ass_java5.controllers.khach_hang;

import com.example.ass_java5.entities.ChiTietSP;
import com.example.ass_java5.repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;

@Controller
@RequestMapping("khach-hang-home")
public class KhachHangHomeControl {

    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Autowired
    private GioHangReopsitory gioHangReopsitory;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private DongSPRepository dspRepo;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    private Page<ChiTietSP> ds;

    @GetMapping("")
    public String index(Model model
            , @RequestParam(value = "page", defaultValue = "0") Integer pageNo
    ) {
//        session = request.getSession();
//        String ma = (String) session.getAttribute("maHoaDon");
//        if(ma == null){
//            session.setAttribute("maHoaDon","");
//        }
        Page<ChiTietSP> lst;
        if(ds == null){
            Pageable pageable = PageRequest.of(pageNo, 5);
            ds = this.chiTietSPRepository.findAll(pageable);
            lst = ds;
        }else{
            lst = (Page<ChiTietSP>) ds.stream().skip(pageNo*5-1).limit(6).collect(Collectors.toList());
        }


        model.addAttribute("lstDongSP", this.dspRepo.findAll());
        model.addAttribute("lstChiTietSP", lst);
        return "home";
    }

    @GetMapping("search")
    public String search(Model model
            , @ModelAttribute("txtSearch") String txtSearch
            , @RequestParam(value = "page", defaultValue = "0") Integer pageNo
    ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        ds = this.chiTietSPRepository.search(txtSearch, pageable);

        model.addAttribute("txtSearch", txtSearch);
        model.addAttribute("lstDongSP", this.dspRepo.findAll());
        model.addAttribute("lstChiTietSP", ds);
        return "home";
    }

}

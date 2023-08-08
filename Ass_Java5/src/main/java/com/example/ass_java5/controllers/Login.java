package com.example.ass_java5.controllers;

import com.example.ass_java5.entities.GioHang;
import com.example.ass_java5.entities.KhachHang;
import com.example.ass_java5.entities.NhanVien;
import com.example.ass_java5.repositories.GioHangReopsitory;
import com.example.ass_java5.repositories.KhachHangRepository;
import com.example.ass_java5.repositories.NhanVienRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("login")
public class Login {

    @Autowired
    private NhanVienRepository nvRepo;

    @Autowired
    private KhachHangRepository khRepo;

    @Autowired
    private GioHangReopsitory gioHangReopsitory;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @GetMapping("")
    public String login(Model model) {
        model.addAttribute("username", "kh1");
        model.addAttribute("password", "123");
        return "login";
    }

    @GetMapping("logout")
    public String logout() {
        session = request.getSession();
        session.removeAttribute("acc");
        session.removeAttribute("kh");
//        session.removeAttribute("checkGioHang");
        session.removeAttribute("maHoaDon");

        return "redirect:/login";
    }

    @PostMapping("")
    public String checkLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("remember") Optional<String> remember,
            Model model
    ) {
        NhanVien nhanVien = this.nvRepo.findByMaAndMatKhau(username, password);
        KhachHang khachHang = this.khRepo.findByMaAndMatKhau(username, password);
        session = request.getSession();

        if (nhanVien == null) {
//            model.addAttribute("valid","vaild");
            if (khachHang == null) {
                return "login";
            } else {
//                session.setAttribute("checkGioHang",0);

                List<GioHang> lstGioHang = this.gioHangReopsitory.findByKhachHang(khachHang);
                GioHang gioHang1 = new GioHang();

                if (lstGioHang.size() <= 0) {
                    GioHang gioHang = toaGioHangMoi(khachHang);
                    gioHang.setKhachHang(khachHang);
                    gioHang1 = this.gioHangReopsitory.save(gioHang);
                } else {
                    gioHang1 = lstGioHang.get(0);
                }
                session.setAttribute("kh", khachHang);
                this.session.setAttribute("maHoaDon", gioHang1.getMa());

                session.removeAttribute("login");
                return "redirect:/khach-hang-home";
            }
        } else {
            session.setAttribute("acc", nhanVien);
//            session.setAttribute("checkGioHang",0);

            session.removeAttribute("login");
            return "redirect:/admin";
        }
    }

    public GioHang toaGioHangMoi(KhachHang khachHang) {
        GioHang gioHang = new GioHang();
        gioHang.setMa("GH0" + khachHang.getMa());
        gioHang.setTinhTrang(0);
        long millis = System.currentTimeMillis();
        java.sql.Date d = new java.sql.Date(millis);
        gioHang.setNgayTao(d);
        return gioHang;
    }

}

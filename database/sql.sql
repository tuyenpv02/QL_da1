

select (select count(d.ma) from  HoaDon d  
                where year(ngaytao) = 2023 and month(ngaytao) =7
                ) as 'tổng HD',
				( select count( ma)  from HoaDon d   where trangthai = 1
                and year(ngaytao) = 2023 and month(ngaytao) =7 ) as 'thanh cong',
                (select count(trangthai) from  HoaDon d  where trangthai = 2 and year(ngaytao) = 2023 
                and month(ngaytao) =7 ) as 'huy'
				,sum(hd.soluong*hd.dongia)  as [doanh thu]
                from HoaDonChiTiet HD  inner join HoaDon d on d.id=hd.IdHoaDon 
                 inner join ChiTietSP ct on ct.Id=hd.IdChiTietSP
                where  year(ngaytao) = 2023 and month(ngaytao) =7 and d.trangthai= 1


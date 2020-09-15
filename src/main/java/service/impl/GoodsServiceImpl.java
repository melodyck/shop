package service.impl;

import entity.PageBean;
import entity.Goods;
import service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao GoodsDao=new GoodsDaoImpl();
    @Override
    public PageBean<Goods> findByPage(int gid, int currentPage, int pageSize) {
        PageBean<Goods> pageBean=new PageBean<>();
        int totalCount=GoodsDao.findCount(gid);
        int start =(currentPage-1)*pageSize;
        List<Goods> byPage = GoodsDao.findByPage(gid, start, pageSize);
        int totalPage = (totalCount + pageSize - 1) / pageSize;
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(byPage);
        pageBean.setTotalCount(totalCount);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public Goods findOne(int gid) {
        return null;
    }
}

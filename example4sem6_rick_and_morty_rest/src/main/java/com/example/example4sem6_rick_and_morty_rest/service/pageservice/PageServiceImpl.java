package com.example.example4sem6_rick_and_morty_rest.service.pageservice;

import com.example.example4sem6_rick_and_morty_rest.model.Page;
import com.example.example4sem6_rick_and_morty_rest.service.viewservice.IRepoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Deprecated
@Service
@RequiredArgsConstructor
public class PageServiceImpl implements IPageService {

    private final IRepoService service;
//    private final int pageSize = 10;
//    private final int pagesCount = Math.round(((float)  service.count()) / pageSize);


//    @Override
//    public Page getPage(int page) {
//        if (service.isEmpty()) {
//            return null;
//        }
//        if (checkOutOfBounds(page)) {
//            if (page < 1) {
//                page = 1;
//            } else {
//                page = pagesCount;
//            }
//        }
//        return new Page(service.getCharacters((page - 1) * pageSize, pageSize), page, pagesCount);
//    }

    @Override
    public void reloadCharacters() {
        if (service.isEmpty()) {
            if (service.isChanged()) {
                service.reloadCharacters();
            }
        }
    }

    private boolean checkOutOfBounds(int page) {
        return page < 1 /*|| page > pagesCount*/;
    }

    @Override
    public int check(int page) {
        if (service.isEmpty()) {
            return 0;
        }
        if (checkOutOfBounds(page)) {
            if (page < 1) {
                page = 1;
//            } else {
//                page = pagesCount;
            }
        }
        return page;
    }

    @Override
    public Page getPageAt(int pageNumber) {


//        service.getCharacters();
        return null;
    }
}


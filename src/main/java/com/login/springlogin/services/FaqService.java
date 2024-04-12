package com.login.springlogin.services;

import java.util.List;
import java.util.Optional;

import com.login.springlogin.DTO.FaqDTO;
import com.login.springlogin.models.Faq;

public interface FaqService {
    public String create(FaqDTO faqDTO);
    public String update(FaqDTO faqDTO);
    public String delete(Integer id);
    public List<Faq> getAll();
    public Optional<Faq> getById(Integer id);
}

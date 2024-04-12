package com.login.springlogin.servicesImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.springlogin.DTO.FaqDTO;
import com.login.springlogin.models.Faq;
import com.login.springlogin.repositories.FaqRepository;
import com.login.springlogin.services.FaqService;

@Service
public class FaqServiceImpl implements FaqService{
    @Autowired
    FaqRepository faqRepository;
    public String create(FaqDTO faqDTO) {
        Faq faq = new Faq(faqDTO.getPregunta(), faqDTO.getRespuesta());
         faqRepository.save(faq);
         return "Faq creado";
    }
    public String update(FaqDTO faqDTO) {
        Faq faq = new Faq(faqDTO.getId(),faqDTO.getPregunta(), faqDTO.getRespuesta(), faqDTO.getPath_file());
        faqRepository.save(faq);
        return "Faq actualizado";
    }
    public String delete(Integer id) {
        faqRepository.deleteById(id);
        return "Faq eliminado";
    }
    public List<Faq> getAll() {
        List<Faq> faqs = faqRepository.findAll();
        return faqs;
    }
    public Optional<Faq> getById(Integer id) {
        Optional<Faq> faq = faqRepository.findById(id);
        return faq;
    }
}

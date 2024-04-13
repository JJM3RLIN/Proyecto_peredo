package com.login.springlogin.servicesImpl;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.ClassPathResource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.login.springlogin.DTO.FaqDTO;
import com.login.springlogin.models.Faq;
import com.login.springlogin.repositories.FaqRepository;
import com.login.springlogin.services.FaqService;

@Service
public class FaqServiceImpl implements FaqService{
    @Autowired
    FaqRepository faqRepository;
    private String PATH_FILES = "./src/main/resources/static/uploads/";
    public String create(FaqDTO faqDTO, MultipartFile file) {
        Faq faq = new Faq(faqDTO.getPregunta(), faqDTO.getRespuesta());
        String archivo = saveFile(file);
        if(!archivo.equals("Error")){
            faq.setPath_file(archivo);
        }        
        faqRepository.save(faq);
         return "Faq creado";
    }
    public String update(FaqDTO faqDTO, MultipartFile file) {
        Faq faq = faqRepository.findById(faqDTO.getId()).get();
        if(faqDTO.getPath_file() != null && !file.isEmpty()){
            deleteFile(faq.getPath_file());
            String archivo = saveFile(file);
            if(!archivo.equals("Error")){
                faq.setPath_file(archivo);
            }
        }
        faqRepository.save(faq);
        return "Faq actualizado";
    }
    public String delete(Integer id) {
        Faq faq = faqRepository.findById(id).get();
        faqRepository.deleteById(id);
        if(faq.getPath_file() != null){
            deleteFile(faq.getPath_file());
        }
        
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

    private String saveFile(MultipartFile file){
        if(!file.isEmpty()){
            //Generar nombre unico para el archivo
            String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
            Path path = Paths.get(PATH_FILES + fileName );

            //Guardamos el archivo en la carpeta
            try {
                Files.write(path, file.getBytes());
                System.out.println("Archivo guardado");
             //Files.copy(file.getInputStream(), path.resolve(fileName));
         } catch (IOException e) {
            System.out.println("Error al guardar el archivo");
            return "Error";
         }
            return fileName;
         }
         return "Error";
    }
    private void deleteFile(String fileName){
        try {
            Path path = Paths.get(PATH_FILES + fileName );
            Files.delete(Paths.get(PATH_FILES + fileName));
        } catch (IOException e) {
            System.out.println("Error al eliminar el archivo");
        }
    }
}

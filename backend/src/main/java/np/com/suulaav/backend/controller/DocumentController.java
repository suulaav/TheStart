package np.com.suulaav.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
public class DocumentController {

  private final DocumentRepository documentRepository;

  @Autowired
  public DocumentController(DocumentRepository documentRepository) {
    this.documentRepository = documentRepository;
  }

  @PostMapping
  public String addDocument(@RequestBody Items document) {
    documentRepository.save(document);
    return "done";
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Items> getDocument(@PathVariable String id) {
    Items items = new Items();
    items.setId(id);
    items.setQuantity(123123123);
    Example<Items> example = Example.of(items);
    return ResponseEntity.ok(documentRepository.findOne(example).get());
  }
}

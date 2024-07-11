package com.example.exportadores.Controller;

import com.example.exportadores.Model.Exporter;
import com.example.exportadores.Repository.ExporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/exporters")
public class ExporterController {

    @Autowired
    private ExporterRepository exporterRepository;

    @GetMapping
    public List<Exporter> getAllExporters() {
        return exporterRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exporter> getExporterById(@PathVariable String id) {
        return exporterRepository.findById(id)
                .map(exporter -> ResponseEntity.ok().body(exporter))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Exporter> createExporter(@RequestBody Exporter exporter) {
        try {
            // Aquí puedes validar y ajustar los datos según tus necesidades
            Exporter createdExporter = exporterRepository.save(exporter);
            return ResponseEntity.ok().body(createdExporter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exporter> updateExporter(@PathVariable String id, @RequestBody Exporter exporterDetails) {
        return exporterRepository.findById(id)
                .map(exporter -> {
                    exporter.setStatus(exporterDetails.getStatus());
                    exporter.setCompany(exporterDetails.getCompany());
                    exporter.setVersion(exporterDetails.getVersion());
                    exporter.setAcceptance(exporterDetails.getAcceptance());
                    exporter.setExpiration(exporterDetails.getExpiration());
                    exporter.setProvince(exporterDetails.getProvince());
                    exporter.setCanton(exporterDetails.getCanton());
                    exporter.setDistrict(exporterDetails.getDistrict());
                    exporter.setEmail(exporterDetails.getEmail());
                    exporter.setSector(exporterDetails.getSector());
                    Exporter updatedExporter = exporterRepository.save(exporter);
                    return ResponseEntity.ok().body(updatedExporter);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateExporterStatus(@PathVariable String id, @RequestBody Map<String, String> statusMap) {
        String newStatus = statusMap.get("status");
        Optional<Exporter> optionalExporter = exporterRepository.findById(id);
        if (!optionalExporter.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Exporter exporter = optionalExporter.get();
        exporter.setStatus(newStatus);
        exporterRepository.save(exporter);

        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExporter(@PathVariable String id) {
        return exporterRepository.findById(id)
                .map(exporter -> {
                    exporterRepository.delete(exporter);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
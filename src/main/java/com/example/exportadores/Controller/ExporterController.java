package com.example.exportadores.Controller;

import com.example.exportadores.Model.Exporter;
import com.example.exportadores.Repository.ExporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
    public Exporter createExporter(@RequestBody Exporter exporter) {
        return exporterRepository.save(exporter);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExporter(@PathVariable String id) {
        return exporterRepository.findById(id)
                .map(exporter -> {
                    exporterRepository.delete(exporter);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

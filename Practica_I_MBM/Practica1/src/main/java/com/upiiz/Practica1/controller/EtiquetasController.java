package com.upiiz.Practica1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EtiquetasController {

    @GetMapping("/") public String index() { return "index"; }

    // --- ESTRUCTURA ---
    @GetMapping("/etiqueta-html") public String etiquetaHtml() { return "etiqueta-html"; }
    @GetMapping("/etiqueta-head") public String etiquetaHead() { return "etiqueta-head"; }
    @GetMapping("/etiqueta-body") public String etiquetaBody() { return "etiqueta-body"; }

    // --- TEXTO ---
    @GetMapping("/etiqueta-p") public String etiquetaP() { return "etiqueta-p"; }
    @GetMapping("/etiqueta-titulos") public String etiquetaTitulos() { return "etiqueta-titulos"; }
    @GetMapping("/etiqueta-span") public String etiquetaSpan() { return "etiqueta-span"; }
    @GetMapping("/etiqueta-strong") public String etiquetaStrong() { return "etiqueta-strong"; }
    @GetMapping("/etiqueta-em") public String etiquetaEm() { return "etiqueta-em"; }

    // --- ENLACES E IMÁGENES ---
    @GetMapping("/etiqueta-a") public String etiquetaA() { return "etiqueta-a"; }
    @GetMapping("/etiqueta-img") public String etiquetaImg() { return "etiqueta-img"; }

    // --- LISTAS ---
    @GetMapping("/etiqueta-ul") public String etiquetaUl() { return "etiqueta-ul"; }
    @GetMapping("/etiqueta-ol") public String etiquetaOl() { return "etiqueta-ol"; }
    @GetMapping("/etiqueta-li") public String etiquetaLi() { return "etiqueta-li"; }

    // --- TABLAS ---
    @GetMapping("/etiqueta-table") public String etiquetaTable() { return "etiqueta-table"; }
    @GetMapping("/etiqueta-tr") public String etiquetaTr() { return "etiqueta-tr"; }
    @GetMapping("/etiqueta-td") public String etiquetaTd() { return "etiqueta-td"; }
    @GetMapping("/etiqueta-th") public String etiquetaTh() { return "etiqueta-th"; }

    // --- FORMULARIOS ---
    @GetMapping("/etiqueta-form") public String etiquetaForm() { return "etiqueta-form"; }
    @GetMapping("/etiqueta-input") public String etiquetaInput() { return "etiqueta-input"; }
    @GetMapping("/etiqueta-label") public String etiquetaLabel() { return "etiqueta-label"; }
    @GetMapping("/etiqueta-button") public String etiquetaButton() { return "etiqueta-button"; }
    @GetMapping("/etiqueta-select") public String etiquetaSelect() { return "etiqueta-select"; }

    // --- MULTIMEDIA ---
    @GetMapping("/etiqueta-audio") public String etiquetaAudio() { return "etiqueta-audio"; }
    @GetMapping("/etiqueta-video") public String etiquetaVideo() { return "etiqueta-video"; }

    // --- SEMÁNTICAS ---
    @GetMapping("/etiqueta-header") public String etiquetaHeader() { return "etiqueta-header"; }
    @GetMapping("/etiqueta-footer") public String etiquetaFooter() { return "etiqueta-footer"; }
    @GetMapping("/etiqueta-section") public String etiquetaSection() { return "etiqueta-section"; }
    @GetMapping("/etiqueta-article") public String etiquetaArticle() { return "etiqueta-article"; }
    @GetMapping("/etiqueta-nav") public String etiquetaNav() { return "etiqueta-nav"; }
}
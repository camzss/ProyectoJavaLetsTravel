
package com.example.Agente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Agente.form.AgenteForm;

/**
 *
 * @author PC
 */
@Controller
public class AgenteController {
    @RequestMapping(value = "/agente", method = RequestMethod.GET)
    public String getAgenteForm() {
        return "agente";
    }

    @RequestMapping(value = "/agente", method = RequestMethod.POST)
    public String agente(@ModelAttribute(name = "agenteForm") AgenteForm agenteForm, Model model) {
        return "agente";
    }

}

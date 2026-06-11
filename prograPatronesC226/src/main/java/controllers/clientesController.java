package controllers;

import dao.clientesDAO;

public class clientesController {
    private clientesDAO _clientesDAO;

    //Metodos del factory(CRUD)

    public clientesController() {
        _clientesDAO = new clientesDAO();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import models.Usuario;
import models.UsuarioDao;

/**
 *
 * @author Winycius
 */
public class Utils {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setNomeCompleto("Winycius Antonio do Canto");
        u.setUsuario("Winycius");
        u.setSenha("1062115");
        new UsuarioDao().insert(u);
        System.out.println(new UsuarioDao().getByEmailAndSenha("Winycius", "1062115").getNomeCompleto());
    }
}

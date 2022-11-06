//package com.feeltech.appbee.service;
//
//import com.feeltech.appbee.model.Apiario;
//import com.feeltech.appbee.model.Colmeia;
//import com.feeltech.appbee.model.Endereco;
//import com.feeltech.appbee.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.ParseException;
//import java.util.Arrays;
//
//@Service
//public class DBService {
//
//    @Autowired
//    private ApiarioRepository apiarioRepository;
//
//    @Autowired
//    private ProducaoAnualRepository producaoAnualRepository;
//
//    @Autowired
//    private ColmeiaRepository colmeiaRepository;
//
//    @Autowired
//    private EnderecoRepository enderecoRepository;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//
//    public void instantiateDatabase() throws ParseException {
//
//        Endereco endereco1 = new Endereco(null, "55900000");
//        Endereco endereco2 = new Endereco(null, "58038330");
//
//        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
//
//        Apiario apiario1 = new Apiario(null, "Apiario Florada Bela", endereco1);
//        Apiario apiario2 = new Apiario(null, "Apiario Flores do Sol", endereco2);
//        Apiario apiario3 = new Apiario(null, "Apiario Mel do Cerrado", endereco1);
//        Apiario apiario4 = new Apiario(null, "Apiario Mel do Campo", endereco2);
//
//        Colmeia colmeia1 = new Colmeia(null, "Colmeia Africana_01", "Apis mellifera", "Laranjeira", apiario1);
//        Colmeia colmeia2 = new Colmeia(null, "Colmeia Africana_02", "Apis mellifera", "Laranjeira", apiario1);
//        Colmeia colmeia3 = new Colmeia(null, "Colmeia Africana_03", "Apis mellifera", "Laranjeira", apiario1);
//        Colmeia colmeia4 = new Colmeia(null, "Colmeia Africana_04", "Apis mellifera", "Laranjeira", apiario1);
//
//        apiario1.getColmeias().addAll(Arrays.asList(colmeia1, colmeia2, colmeia3, colmeia4));
//
//        Colmeia colmeia5 = new Colmeia(null, "Colmeia Jatai_01", "Tetragonisca angustula", "Flores Silvestres", apiario2);
//        Colmeia colmeia6 = new Colmeia(null, "Colmeia Jatai_02", "Tetragonisca angustula", "Flores Silvestres", apiario2);
//        Colmeia colmeia7 = new Colmeia(null, "Colmeia Jatai_03", "Tetragonisca angustula", "Flores Silvestres", apiario2);
//
//        apiario2.getColmeias().addAll(Arrays.asList(colmeia5, colmeia6, colmeia7));
//
//        Colmeia colmeia8 = new Colmeia(null, "Colmeia Urucu_01", "Melipona rufiventris", "Flores do Cerrado", apiario3);
//        Colmeia colmeia9 = new Colmeia(null, "Colmeia Urucu_02", "Melipona rufiventris", "Flores do Cerrado", apiario3);
//        Colmeia colmeia10 = new Colmeia(null, "Colmeia Urucu_03", "Melipona rufiventris", "Flores do Cerrado", apiario3);
//
//        apiario3.getColmeias().addAll(Arrays.asList(colmeia8, colmeia9, colmeia10));
//
//        Colmeia colmeia11 = new Colmeia(null, "Colmeia Mielera_01", "Melipona scutellaris", "Flores do Campo", apiario4);
//        Colmeia colmeia12 = new Colmeia(null, "Colmeia Mielera_02", "Melipona scutellaris", "Flores do Campo", apiario4);
//        Colmeia colmeia13 = new Colmeia(null, "Colmeia Mielera_03", "Melipona scutellaris", "Flores do Campo", apiario4);
//
//        apiario4.getColmeias().addAll(Arrays.asList(colmeia11, colmeia12, colmeia13));
//
//
//        apiarioRepository.saveAll(Arrays.asList(apiario1, apiario2, apiario3, apiario4));
//
//
//
//
//
//
//
//
//
//
//
//    }
//
//
//
//
//}

package br.meli.apiprodutos.repositories;

import br.meli.apiprodutos.models.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoRepository {
    private static final Map<Long, Produto> db = new HashMap<>();
    private static Long id = 1L;

    public static List<Produto> findAll() {
        List<Produto> res = new ArrayList<>();

        for(Map.Entry<Long, Produto> produto : db.entrySet()) {
            res.add(produto.getValue());
        }

        return  res;
    }

    public static Produto findById(Long id) {
        if (db.containsKey(id)) {
            return db.get(id);
        }

        return null;
    }

    public static Produto add(Produto produto) {
        produto.setId(id);
        db.put(id, produto);
        id++;

        return db.get(id);
    }

    public static Produto update(Long id, Produto produto) {
        if (db.containsKey(id)) {
            produto.setId(id);
            db.put(id, produto);
        }

        return null;
    }

    public static Produto delete(Long id) {
        if (db.containsKey(id)){
            return db.remove(id);
        }

        return null;
    }
}

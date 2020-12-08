package com.proxy.hideme.mapper;

import com.proxy.hideme.model.Proxy;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.util.*;
import java.util.function.BiFunction;

public class ProxyMapper {

    private ProxyMapper(){}

    /**
     * Parse Jsoup Node to Proxy object
     * @param parentNode Jsoup node
     * @return Proxy
     */
    public static Proxy mapper(Node parentNode) {
        BiFunction<Node, Integer, String> getNElementFromNode = (node, i) ->
                node.childNodes().get(i).childNodes().get(0).toString();

        return new Proxy()
                .ip(getNElementFromNode.apply(parentNode, 0))
                .port(Integer.parseInt(getNElementFromNode.apply(parentNode, 1)))
                .country(Optional.ofNullable(parentNode.childNodes().get(2).childNodes().get(2).childNodes()).orElse(Collections.singletonList(new TextNode("Unknown"))).toString().replace("[", "").replace("]", ""))
                .response(Integer.parseInt(Arrays.stream(parentNode.childNodes().get(3).childNodes().get(0).childNodes().get(0).childNodes().get(0).toString().split(" ")).findFirst().orElse("0")))
                .type(getNElementFromNode.apply(parentNode, 4))
                .security(getNElementFromNode.apply(parentNode, 5))
                .updated(Integer.parseInt(Arrays.stream(getNElementFromNode.apply(parentNode, 6).split(" ")).findFirst().orElse("0")))
                .build();
    }
}

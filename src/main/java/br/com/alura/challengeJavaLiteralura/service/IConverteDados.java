package br.com.alura.challengeJavaLiteralura.service;

public interface IConverteDados {
   <T> T obterDados(String json, Class<T> classe );

   }
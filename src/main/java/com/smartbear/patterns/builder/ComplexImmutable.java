package com.smartbear.patterns.builder;

public interface ComplexImmutable {

    public String performAction();

    public static class ComplexImmutableBuilder{
        public StrictModeConfigurator withConnectionTimeout(final int timeout) {
            return new StrictModeConfigurator() {
                public NameConfigurator usingStrictMode(final boolean strict){
                     return new NameConfigurator(){
                         public NameSpaceConfigurator named(final String name) {
                             return new NameSpaceConfigurator() {
                                 public ContextConfigurator inNameSpace(final String namespace) {
                                       return new ContextConfigurator() {
                                           public AspectConfigurator withContext(final String context) {
                                               return new AspectConfigurator() {
                                                   public Builder initializedTo(final long value) {
                                                         return new Builder() {
                                                             public ComplexImmutable build() {
                                                                 return new ComplexImmutableObject(timeout,strict,name,namespace,context,value);
                                                             }
                                                         };
                                                   }
                                                   public InitialValueConfigurator withAspect(final String aspect) {
                                                       return new InitialValueConfigurator(){

                                                           @Override
                                                           public Builder initializedTo(final long value) {
                                                               return new Builder() {
                                                                   public ComplexImmutable build() {
                                                                       return new ExtraComplexImmutableObject(new ComplexImmutableObject(timeout,strict,name,namespace,context,value),aspect);
                                                                   }
                                                               };
                                                           };
                                                       };
                                                   }
                                               };
                                           }
                                       };
                                 }
                             };
                         }
                     };
                }
            };
        }
    }
    // return new ComplexImmutableObject(timeout,strict,name,namespace,context,value);
    public static interface StrictModeConfigurator {
        NameConfigurator usingStrictMode(boolean strict);
    }
    public static interface NameConfigurator {
        NameSpaceConfigurator named(String name);
    }
    public static interface NameSpaceConfigurator {
        ContextConfigurator inNameSpace(String namespace);
    }
    public static interface ContextConfigurator {
        AspectConfigurator withContext(String context);
    }
    public static interface AspectConfigurator extends InitialValueConfigurator {
        InitialValueConfigurator withAspect(String aspect);
    }
    public static interface InitialValueConfigurator {
        Builder initializedTo(long value);
    }
    public static interface Builder{
        ComplexImmutable build();
    }
}

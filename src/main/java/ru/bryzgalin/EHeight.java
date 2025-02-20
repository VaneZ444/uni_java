package ru.bryzgalin;

enum EHeight{
    SHORT(170){

    },MEDIUM(190),TALL(220);
    private final int height;
    EHeight(int height){
        this.height = height;
    }
    Enum<EHeight> withValue(int i){
        if(i>=190) return TALL;
        if(i>=170) return MEDIUM;
        return SHORT;
    }
}

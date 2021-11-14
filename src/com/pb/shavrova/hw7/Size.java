package com.pb.shavrova.hw7;

enum Size {
    XXS(32) {
        @Override
        public String getDescription() {
            return "детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    Size(int euroSize, String description) {
        this.euroSize = euroSize;
        this.description = description;
    }

    private int euroSize;
    private String description;

    Size (int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public String getDescription() {
        return "взрослый размер";
    }

    @Override
    public String toString() {
        return name() + "(" + euroSize + ") " + getDescription();
    }
}




package com.sora.sample3;

/**
 * @Classname TwoAdapter
 * @Description
 * @Date 2024/09/23 13:44
 * @Author by Sora33
 */
public class TwoAdapter implements Two{

    ThreeImpl threeImpl;

    public TwoAdapter(ThreeImpl threeImpl) {
        this.threeImpl = threeImpl;
    }

    @Override
    public void play(int id1, int id2) {
        threeImpl.play(id1, id2, -999);
    }
}

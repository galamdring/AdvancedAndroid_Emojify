package com.example.android.emojify;

public class FaceType{
    private float leftEyeOpenProb;
    private float rightEyeOpenProb;
    private float smilingProb;

    private boolean leftEyeOpen;
    private boolean rightEyeOpen;
    private boolean smiling;

    private final double SMILING_THRESHOLD=.15;
    private final double EYE_OPEN_THRESHOLD=.5;

    public FaceType(float leftEyeOpen, float rightEyeOpen, float smiling) {
        this.leftEyeOpenProb = leftEyeOpen;
        this.rightEyeOpenProb = rightEyeOpen;
        this.smilingProb = smiling;

        this.leftEyeOpen=(leftEyeOpenProb >= EYE_OPEN_THRESHOLD);
        this.rightEyeOpen=rightEyeOpenProb>=EYE_OPEN_THRESHOLD;
        this.smiling=smilingProb>=SMILING_THRESHOLD;

    }

    public Emoji getEmoji(){
        Emoji emoji = Emoji.SMILE;
        if(smiling){
            if(rightEyeOpen && !leftEyeOpen){
                emoji=Emoji.LEFT_WINK;
            }else if(!rightEyeOpen && leftEyeOpen){
                emoji=Emoji.RIGHT_WINK;
            }
            else if(!leftEyeOpen&&!rightEyeOpen){
                emoji=Emoji.CLOSED_EYE_SMILE;
            }
            else emoji=Emoji.SMILE;
        }else{
            if(rightEyeOpen && !leftEyeOpen){
                emoji=Emoji.LEFT_WINK_FROWN;
            }else if(!rightEyeOpen && leftEyeOpen){
                emoji=Emoji.RIGHT_WINK_FROWN;
            }
            else if(!leftEyeOpen&&!rightEyeOpen){
                emoji=Emoji.CLOSED_EYE_FROWN;
            }
            else emoji=Emoji.FROWN;
        }
        return emoji;
    }

    public boolean getSmiling() {
        return smiling;
    }

    public boolean getRightEyeOpen() {
        return rightEyeOpen;
    }

    public boolean getLeftEyeOpen() {
        return leftEyeOpen;
    }


    public enum Emoji{
        SMILE,
        FROWN,
        LEFT_WINK,
        RIGHT_WINK,
        LEFT_WINK_FROWN,
        RIGHT_WINK_FROWN,
        CLOSED_EYE_SMILE,
        CLOSED_EYE_FROWN
    }
}

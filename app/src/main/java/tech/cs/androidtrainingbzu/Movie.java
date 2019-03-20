package tech.cs.androidtrainingbzu;

public class Movie {

        private int mImageResource;
        private String mText1;
        private String mText2;

    public Movie(int mImageResource, String mText1, String mText2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public int getImageResource() {
            return mImageResource;
        }

        public String getText1() {
            return mText1;
        }

        public String getText2() {
            return mText2;
        }
    }


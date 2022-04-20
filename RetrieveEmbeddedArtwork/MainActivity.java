
 @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        String myUrl = "$musicUrlHere";

        Uri uri = Uri.parse(myUrl);

        setArtworkFromMediaMetadata(uri);

    }

    /**

     * #dependencies->

     * implementation 'com.github.wseemann:FFmpegMediaMetadataRetriever-core:1.0.16'

     * implementation 'com.github.wseemann:FFmpegMediaMetadataRetriever-native:1.0.16'

     * implementation 'com.github.bumptech.glide:glide:4.13.1'

     * annotationProcessor
'com.github.bumptech.glide:compiler:4.13.0'

     *
* <-#dependencies


     * @param uri to show all windows.

     */ 

    private void setArtworkFromMediaMetadata(Uri uri) {

       

        FFmpegMediaMetadataRetriever retriever = new FFmpegMediaMetadataRetriever();

        retriever.setDataSource(uri.toString());

        byte[] bytes = retriever.getEmbeddedPicture(); //bytes of a artwork

        Glide

                .with(this)

                .load(bytes)

                .apply(new RequestOptions()

                        .placeholder(R.drawable.test_image)

                        .diskCacheStrategy(DiskCacheStrategy.NONE)

                        .skipMemoryCache(true)

                )

                .transition(new DrawableTransitionOptions()

                         .crossFade())

                .into(imageView);// ImageView

    }

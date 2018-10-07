# SvgSamples

Samples of loading SVG files from assets and network into an ImageView by using Glide and AndroidSVG

```kotlin
val svgFileName = "android.svg"

// Show the SVG file by Glide.
val svgUri = Uri.parse("file:///android_asset/$svgFileName")
Glide.with(this)
  .`as`(PictureDrawable::class.java)
  .transition(DrawableTransitionOptions.withCrossFade())
  .listener(SvgSoftwareLayerSetter())
  .load(svgUri)
  .into(glideSvgImageView)

// Show the SVG file by SVGImageView.
androidSvgImageView.setImageAsset(svgFileName)
```

![samples](android-svg-glide.png)

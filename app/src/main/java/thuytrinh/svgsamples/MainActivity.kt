package thuytrinh.svgsamples

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

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
  }
}

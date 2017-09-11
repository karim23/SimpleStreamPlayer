package com.rubit.simplestreamplayer.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.rubit.simplestreamplayer.R;
import com.rubit.simplestreamplayer.utilties.DemoUtil;

public class MainActivity extends Activity {

	private Context context;
	private String contentUri;
	private TextView liveStreamingTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getApplicationContext();
		setContentView(R.layout.activity_main);
		//		contentUri = "http://abclive.abcnews.com/i/abc_live4@136330/index_1200_av-b.m3u8?sd=10&b=1200&rebase=on";
//		contentUri = "http://184.72.239.149/vod/smil:BigBuckBunny.smil/playlist.m3u8";

		contentUri = "https://bitmovin-a.akamaihd.net/content/playhouse-vr/m3u8s/105560.m3u8";

//		contentUri ="https://r4---sn-uxaxjvhxbt2u-5atr.googlevideo.com/videoplayback?key=yt6&itag=22&mime=video/mp4&source=youtube&ms=au&mv=m&mt=1505119252&dur=712.202&requiressl=yes&id=o-AP35xz-ZNTTI7njXLL3dDl0-sPMryzr1hqdIRXLePRve&pl=24&mn=sn-uxaxjvhxbt2u-5atr&mm=31&signature=5DB054BA2B3B95ADB64A0E1706F9BA524D8054B5.D2A309118C5ACEE81E71C4A35919CDC4A96DD82A&sparams=dur,ei,id,initcwndbps,ip,ipbits,itag,lmt,mime,mm,mn,ms,mv,pl,ratebypass,requiressl,source,expire&ip=41.39.30.94&expire=1505140981&ratebypass=yes&ipbits=0&lmt=1471657622742789&ei=lUy2WbjSLcOtVaOEp_AD&initcwndbps=160000,itag=43&type=video/webm";

		// contentType = DemoUtil.TYPE_HLS;
		final Intent intent = new Intent(context, VideoPlayerActivity.class).setData(Uri.parse(contentUri))
				.putExtra(VideoPlayerActivity.CONTENT_ID_EXTRA, -1)
				//Change the type according to the live streaming extension.
				.putExtra(VideoPlayerActivity.CONTENT_TYPE_EXTRA, DemoUtil.TYPE_MP4);
//				.putExtra(VideoPlayerActivity.CONTENT_TYPE_EXTRA, DemoUtil.TYPE_HLS);

		liveStreamingTv =(TextView)findViewById(R.id.mainActivity_liveStreamingTv);
		liveStreamingTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(intent);
			}
		});
	}
}

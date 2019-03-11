package selenium2;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.sun.jna.NativeLibrary;

//import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class ScreenRecorder {

	
//	private final Logger logger = LoggerFactory.getLogger(ScreenRecorder.class);
	private static final String[] OPTIONS = { "--quiet", "--quiet-synchro", "--intf", "dummy" };
	private static final String MRL = "screen://Troop Messenger";
	//private static final String MRL = "screen://";
	private static final String SOUT = ":sout=#transcode{vcodec=h264,vb=%d,scale=%f}:duplicate{dst=file{dst=%s}}";
	private static final String FPS = ":screen-fps=%d";
	private static final String CACHING = ":screen-caching=%d";

	private static final int fps = 20;
	private static final int caching = 500;
	private static final int bits = 1024;
	private static final float scale = 1.8f;

	private final MediaPlayerFactory mediaPlayerFactory;
	private final MediaPlayer mediaPlayer;

	public String videoName;
	public String mp4FileName;

	public ScreenRecorder() {
		NativeLibrary.addSearchPath("vlc", "/Applications/VLC.app/Contents/MacOS/lib");
		System.setProperty("jna.library.path", "/Applications/VLC.app/Contents/MacOS/lib");
		mediaPlayerFactory = new MediaPlayerFactory(OPTIONS);
		mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
	}

	public void startRecording(String testName) {
		mp4FileName = getFile(testName);
//		logger.info("start recording, " + mp4FileName);
		mediaPlayer.playMedia(MRL, getMediaOptions(mp4FileName));
	}

	public void stopRecording() {
//		logger.info("stop recording ");
		mediaPlayer.stop();
	}

	public void releaseRecordingResources() {
		mediaPlayer.release();
		mediaPlayerFactory.release();
	}

	private String getFile(String testName) {
		File dir = new File(System.getProperty("user.dir") + "/test-output", "mp4Result");
		dir.mkdirs();
		DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		videoName = df.format(new Date()) + ".mp4";
		System.out.println(videoName);
		return dir.getAbsolutePath() + "/" + testName + videoName;
	}

	private String[] getMediaOptions(String destination) {
		return new String[] { String.format(SOUT, bits, scale, destination), String.format(FPS, fps),
				String.format(CACHING, caching) };
	}
	@Test
	public void demo() throws InterruptedException
	{
		
		startRecording("test");
		Thread.sleep(5000);
		stopRecording();
	}
	
	
	
	
}

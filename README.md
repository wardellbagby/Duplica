# Duplica for Wear Ditto

Duplica is an app that allows you to arbitrary force your attached
[Ditto device](https://dittowearable.com/) to vibrate.

## How It Works

Duplica accepts Intents directed to its BroadcastReceiver, and will
forward those to the [Ditto app](https://play.google.com/store/apps/details?id=com.simplematters.wearditto), causes it to tell the Ditto to vibrate.
This does not communicate directly with the Ditto device, so the Ditto
app must be installed.

## How To Use

Duplica was made with [Tasker](https://play.google.com/store/appsx/details?id=net.dinglisch.android.taskerm)
in mind, and so that's the simplest way to interact with Duplica.

### Setting up:

1. Download the latest version of Duplica from the [Releases page.](https://github.com/wardellbagby/Duplica/releases)
2. [Import the Vibrate Ditto task into Tasker using this link.](https://taskernet.com/shares/?user=AS35m8ktGt5xF1BuHn%2FM5NhwSiLDqKCqdN66geGz7DOt5U80RYo2uQ24Itpr%2FyL67MNOTj%2FotFke%2BiA%3D&id=Task%3AVibrate+Ditto)
3. Setup a Tasker profile that will activate on a Notification Event from apps that you're interested in.
4. Have the Tasker profile activate the Vibrate Ditto task.
5. Enjoy!
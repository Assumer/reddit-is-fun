/*
 * This file is part of "reddit is fun".
 *
 * "reddit is fun" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * "reddit is fun" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with "reddit is fun".  If not, see <http://www.gnu.org/licenses/>.
 */

package com.andrewshu.android.redditdonation;

import java.util.ArrayList;

import android.text.style.URLSpan;

public class Util {
	
    public static ArrayList<String> extractUris(URLSpan[] spans) {
        int size = spans.length;
        ArrayList<String> accumulator = new ArrayList<String>();

        for (int i = 0; i < size; i++) {
            accumulator.add(spans[i].getURL());
        }
        return accumulator;
    }
	
	/**
	 * To the second, not millisecond like reddit
	 * @param timeSeconds
	 * @return
	 */
	public static String getTimeAgo(long utcTimeSeconds) {
		long systime = System.currentTimeMillis() / 1000;
		long diff = systime - utcTimeSeconds;
		if (diff <= 0)
			return "very recently";
		else if (diff < 60) {
			if (diff == 1)
				return "1 second ago";
			else
				return diff + " seconds ago";
		}
		else if (diff < 3600) {
			if ((diff / 60) == 1)
				return "1 minute ago";
			else
				return (diff / 60) + " minutes ago";
		}
		else if (diff < 86400) { // 86400 seconds in a day
			if ((diff / 3600) == 1)
				return "1 hour ago";
			else
				return (diff / 3600) + " hours ago";
		}
		else if (diff < 604800) { // 86400 * 7
			if ((diff / 86400) == 1)
				return "1 day ago";
			else
				return (diff / 86400) + " days ago";
		}
		else if (diff < 2592000) { // 86400 * 30
			if ((diff / 604800) == 1)
				return "1 week ago";
			else
				return (diff / 604800) + " weeks ago";
		}
		else if (diff < 31536000) { // 86400 * 365
			if ((diff / 2592000) == 1)
				return "1 month ago";
			else
				return (diff / 2592000) + " months ago";
		}
		else {
			if ((diff / 31536000) == 1)
				return "1 year ago";
			else
				return (diff / 31536000) + " years ago";
		}
	}
	
	public static String getTimeAgo(double utcTimeSeconds) {
		return getTimeAgo((long)utcTimeSeconds);
	}
}

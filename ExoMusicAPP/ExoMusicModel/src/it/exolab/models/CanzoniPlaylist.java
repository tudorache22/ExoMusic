package it.exolab.models;

public class CanzoniPlaylist {
	private Playlist playlist;
	private Canzone canzone;

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Canzone getCanzone() {
		return canzone;
	}

	public void setCanzone(Canzone canzone) {
		this.canzone = canzone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canzone == null) ? 0 : canzone.hashCode());
		result = prime * result + ((playlist == null) ? 0 : playlist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CanzoniPlaylist other = (CanzoniPlaylist) obj;
		if (canzone == null) {
			if (other.canzone != null)
				return false;
		} else if (!canzone.equals(other.canzone))
			return false;
		if (playlist == null) {
			if (other.playlist != null)
				return false;
		} else if (!playlist.equals(other.playlist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CanzoniPlaylist [playlist=" + playlist + ", canzone=" + canzone + "]";
	}

}

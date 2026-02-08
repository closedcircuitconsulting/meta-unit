# meta-unit-graphics

## U-boot splash
The u-boot splash has bee configured to show the [yocto project logo](https://commons.wikimedia.org/wiki/File:Yocto_Project_logo.svg).

To convert the logo to a u-boot compatible bitmap, the following command was used:
```bash
convert yocto_project_logo.png -resize 700x400 -background white -gravity center -extent 800x480 -depth 8 -type TrueColor -compress none BMP3:yocto_project_logo_800x480_24bpp.bmp
```

The dimensions for `resize` and `extent` are device specific.

cmake_minimum_required(VERSION 3.4.1)
add_library( # Sets the name of the library.
             dexmanager
             # Sets the library as a shared library.
             SHARED
             # Provides a relative path to your source file(s).
             src/main/cpp/dexmanager.cpp
              src/main/cpp/art_method.h
             )

find_library( # Sets the name of the path variable.
              log-lib
              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries(
                       dexmanager

                       ${log-lib} )
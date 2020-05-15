#!/bin/bash

if [ ! -d target/ ]; then echo "target/ does not exist!"; exit 1; fi

cd target/
for f in *.jar; do
    mv "$f" "`echo $f $1 | perl -pe 's/^((?:[^-]*?-){2}[^-]*?)((?:-sources)?\.jar) (.+)$/$1-$3$2/g' \
                         | perl -pe 's/^(.*?) (.+)$/$1/g'`"
done

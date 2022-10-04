ASCIIDOCTOR_REVEALJS=asciidoctor-revealjs

INPUT_SLIDES=slides/index.adoc
ASCIIDOCTOR_REVEALJS_OPTS=-r asciidoctor-kroki

OUT_DIR=out

.PHONY: clean build
.FORCE:

all: clean build

build: .FORCE
	mkdir -p $(OUT_DIR)
	$(ASCIIDOCTOR_REVEALJS) $(ASCIIDOCTOR_REVEALJS_OPTS) $(INPUT_SLIDES) -o $(OUT_DIR)/index.html
	cp -r slides/images $(OUT_DIR)

clean:
	@rm -fr $(OUT_DIR)

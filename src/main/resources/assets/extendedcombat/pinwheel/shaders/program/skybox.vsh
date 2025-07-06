#version 150

out vec3 TexCoords; // Output texture coordinates for fragment shader

// Fullscreen triangle positions (avoids using a full quad)
const vec2 positions[3] = vec2[](
vec2(-1.0, -1.0),
vec2(3.0, -1.0),
vec2(-1.0, 3.0)
);

void main() {
    vec2 pos = positions[gl_VertexID].xy; // Fetch triangle position
    gl_Position = vec4(pos, 0.0, 1.0);

    // Reconstruct cube map texture coordinates from screen position
    TexCoords = normalize(vec3(pos, 1.0));
}